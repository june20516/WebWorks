<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<body>
<h2>JavaScript Objects</h2>

<p id="demo" ></p>


<script>
// Create an object:
var person = {
  firstName: "John",
  lastName : "Doe",
  id       : 5566,
  fullName : function() {
    return this.firstName + " " + this.lastName;
  }
};

//Display some data from the object:
document.getElementById("demo").innerHTML =
	person.fullName();
</script>

</body>
</html>
