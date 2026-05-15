package org.onlineexam.repository;

import java.util.ArrayList;
import java.util.List;

import org.onlineexam.model.ResultModel;

public class ResultServiceRepoImpl extends DBConfig implements ResultServiceRepo {

    @Override
    public List<ResultModel> getAllResults() {
        List<ResultModel> list = new ArrayList<>();

        try {

            stmt = conn.prepareStatement(

                    "select r.*, " +
                            "u.full_name, " +
                            "e.exam_title " +

                            "from result r " +

                            "inner join users u " +
                            "on r.user_id = u.user_id " +

                            "inner join exam e " +
                            "on r.exam_id = e.exam_id " +

                            "inner join ( " +

                            "select user_id, exam_id, " +
                            "max(obtained_marks) as max_marks " +

                            "from result " +

                            "group by user_id, exam_id " +

                            ") x " +

                            "on r.user_id = x.user_id " +
                            "and r.exam_id = x.exam_id " +
                            "and r.obtained_marks = x.max_marks"

            );

            rs = stmt.executeQuery();

            while (rs.next()) {

                ResultModel model = new ResultModel();

                model.setResultId(
                        rs.getInt("result_id"));

                model.setUserId(
                        rs.getInt("user_id"));

                model.setExamId(
                        rs.getInt("exam_id"));

                model.setObtainedMarks(
                        rs.getInt("obtained_marks"));

                model.setTotalMarks(
                        rs.getInt("total_marks"));

                model.setPercentage(
                        rs.getDouble("percentage"));

                model.setResultStatus(
                        rs.getString("result_status"));

                model.setUserName(
                        rs.getString("full_name"));

                model.setExamTitle(
                        rs.getString("exam_title"));

                list.add(model);
            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return list;
    }

    @Override
    public List<ResultModel> getAllAdminResults() {

        List<ResultModel> list =
                new ArrayList<ResultModel>();

        try {

            stmt = conn.prepareStatement(

            "select r.result_id, " +
            "u.full_name, " +
            "e.exam_title, " +
            "r.obtained_marks, " +
            "r.total_marks, " +
            "r.percentage, " +
            "r.result_status " +
            "from result r " +
            "inner join users u " +
            "on r.user_id=u.user_id " +
            "inner join exam e " +
            "on r.exam_id=e.exam_id " +
            "order by r.result_id desc"

            );

            rs = stmt.executeQuery();

            while(rs.next()) {

                ResultModel model =
                        new ResultModel();

                model.setResultId(
                        rs.getInt("result_id"));

                model.setUserName(
                        rs.getString("full_name"));

                model.setExamTitle(
                        rs.getString("exam_title"));

                model.setObtainedMarks(
                        rs.getInt("obtained_marks"));

                model.setTotalMarks(
                        rs.getInt("total_marks"));

                model.setPercentage(
                        rs.getDouble("percentage"));

                model.setResultStatus(
                        rs.getString("result_status"));

                list.add(model);
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return list;
    }

}
