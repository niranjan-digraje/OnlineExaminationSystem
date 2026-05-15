package org.onlineexam.service;

import java.util.List;

import org.onlineexam.model.ResultModel;
import org.onlineexam.repository.ResultServiceRepo;
import org.onlineexam.repository.ResultServiceRepoImpl;

public class ResultServiceImpl implements ResultService  {
    ResultServiceRepo repo = new ResultServiceRepoImpl();
    @Override
    public List<ResultModel> getAllResults() {
        return repo.getAllResults();
    }

    @Override
    public List<ResultModel> getAllAdminResults() {
        return repo.getAllAdminResults();
    }

}
