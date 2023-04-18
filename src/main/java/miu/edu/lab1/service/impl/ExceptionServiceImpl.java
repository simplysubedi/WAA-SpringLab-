package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.ExceptionLog;
import miu.edu.lab1.respository.ExceptionRepository;
import miu.edu.lab1.service.ExceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionServiceImpl implements ExceptionService {
    @Autowired
    ExceptionRepository exceptionRepository;

    @Override
    public void addException(ExceptionLog exception) {
        exceptionRepository.save(exception);
    }
}
