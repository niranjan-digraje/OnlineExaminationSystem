package org.onlineexam.repository;

import java.util.List;
import org.onlineexam.model.ResultModel;

public interface ResultServiceRepo {

    public List<ResultModel> getAllResults();
}