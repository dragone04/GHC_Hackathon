package it.nexi.hackathon.service;

import it.nexi.hackathon.entity.CategoryTransactionSummary;
import it.nexi.hackathon.entity.Transaction;
import it.nexi.hackathon.entity.YearMonthTransactionSummary;
import it.nexi.hackathon.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Iterable<Transaction> findAll() {
        return repository.findAll();
    }

    public Iterable<Transaction> findAllByCustomerId(Integer customerId) {
        return repository.findTransactionByCustomerCustomerId(customerId);
    }

    public Iterable<Transaction> findAllByCustomerIdAndDate(Integer customerId, LocalDate startDate, LocalDate endDate) {
        return repository.findTransactionByCustomerCustomerIdAndTransDateBetween(customerId, startDate, endDate);
    }

    public Optional<Transaction> findOne(String id) {
        return repository.findById(id);
    }

    public Optional<Transaction> updateOne(String id, Transaction update) {
        return repository.findById(id).map(existing -> {
            existing.setAmount(update.getAmount());
            existing.setTransDate(update.getTransDate());
            existing.setCategory(update.getCategory());
            existing.setCustomer(update.getCustomer());
            return repository.save(existing);
        });
    }

    public void deleteOne(String id) {
        repository.deleteById(id);
    }

    //write a method to call repository sumAmountByCategoryAndCustomerAndDateRange
    public List<CategoryTransactionSummary> sumAmountByCategoryAndCustomerAndDateRange(Integer customerId, LocalDate startDate, LocalDate endDate) {
        return repository.sumAmountByCategoryAndCustomerAndDateRange(customerId, startDate, endDate);
    }

    public List<YearMonthTransactionSummary> sumAmountByYearAndMonthAndCustomerAndDateRange(Integer customerId, LocalDate startDate, LocalDate endDate) {
        return repository.sumAmountByYearAndMonthAndCustomerAndDateRange(customerId, startDate, endDate);
    }

}
