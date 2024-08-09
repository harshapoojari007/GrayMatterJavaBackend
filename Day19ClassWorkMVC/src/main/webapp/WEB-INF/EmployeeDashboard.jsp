<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
<script type="text/javascript">
       
        function showAlert(message) {
            if (message) {
                alert(message);
            }
        }
        showAlert(${alertMessage});
    </script>
    
</head>

<body>
<h1>Welcome user ${username}</h1>
<h1>Employee Dashboard</h1>
<h1>${message}</h1>
<button>
<a href="add" >Add Employee</a>
</button>
<button>
<a href="delete" >Delete Employee</a>
</button>
<button>
<a href="update" >Update Employee</a>
</button>
<button>
<a href="employee" >Get All Employee</a>
</button>
<button>
<a href="byid" >Get Employee</a>
</button>
</form>
</body>
</html>