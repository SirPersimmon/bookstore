package ru.guap.opi.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import ru.guap.opi.bookstore.exception.NotFoundException;
import ru.guap.opi.bookstore.db.dao.ReceiptRepository;
import ru.guap.opi.bookstore.db.model.Receipt;
import ru.guap.opi.bookstore.dto.ReceiptDto;
import ru.guap.opi.bookstore.mapper.ReceiptMapper;

@Service
public class ReceiptServiceImpl implements ReceiptService {
    private final ReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public ReceiptServiceImpl(ReceiptRepository receiptRepository, ReceiptMapper receiptMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public List<ReceiptDto> findAll() {
        return receiptRepository.findAll().stream()
                .map(receiptMapper::receiptToReceiptDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReceiptDto findById(Integer id) {
        return receiptMapper
                .receiptToReceiptDto(receiptRepository.findById(id).orElseThrow(() -> new NotFoundException()));
    }

    @Override
    public ReceiptDto add(ReceiptDto receiptDto) {
        receiptDto.setId(null);
        Receipt receipt = receiptRepository.save(receiptMapper.receiptDtoToReceipt(receiptDto));
        return receiptMapper.receiptToReceiptDto(receipt);
    }

    @Override
    public ReceiptDto update(Integer id, ReceiptDto receiptDto) {
        if (!receiptRepository.existsById(id)) {
            throw new NotFoundException();
        }

        receiptDto.setId(id);
        Receipt receipt = receiptRepository.save(receiptMapper.receiptDtoToReceipt(receiptDto));
        return receiptMapper.receiptToReceiptDto(receipt);
    }

    @Override
    public void delete(Integer id) {
        if (!receiptRepository.existsById(id)) {
            throw new NotFoundException();
        }

        receiptRepository.deleteById(id);
    }
}
