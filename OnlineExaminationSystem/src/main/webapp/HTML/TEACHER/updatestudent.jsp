<%@page import="org.onlineexam.model.UserModel"%>

<%

UserModel m =
(UserModel)request.getAttribute("student");

%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Update Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

</head>

<body>

<div class="container mt-5">

    <div class="card p-4 shadow">

        <h2 class="text-center mb-4">

            Update Student

        </h2>

        <form action="/OnlineExaminationSystem/finalupdatestudent"
              method="post">

            <input type="hidden"
                   name="id"
                   value="<%=m.getUserId()%>">

            <div class="mb-3">

                <label>Name</label>

                <input type="text"
                       name="name"
                       value="<%=m.getUserName()%>"
                       class="form-control">

            </div>

            <div class="mb-3">

                <label>Email</label>

                <input type="email"
                       name="email"
                       value="<%=m.getUserEmail()%>"
                       class="form-control">

            </div>

            <div class="mb-3">

                <label>Password</label>

                <input type="text"
                       name="password"
                       value="<%=m.getUserPassword()%>"
                       class="form-control">

            </div>

            <div class="mb-3">

                <label>Mobile</label>

                <input type="text"
                       name="mobile"
                       value="<%=m.getUserMobile()%>"
                       class="form-control">

            </div>

            <div class="mb-3">

                <label>Gender</label>

                <select name="gender"
                        class="form-control">

                    <option value="Male">Male</option>

                    <option value="Female">Female</option>

                </select>

            </div>

            <button type="submit"
                    class="btn btn-primary w-100">

                Update Student

            </button>

        </form>

    </div>

</div>

</body>
</html>