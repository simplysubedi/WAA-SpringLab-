package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.Logger;
import miu.edu.lab1.respository.LoggerRepository;
import miu.edu.lab1.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepository loggerRepository;

    @Override
    public void addTransaction(Logger logger) {
        loggerRepository.save(logger);
    }
}
