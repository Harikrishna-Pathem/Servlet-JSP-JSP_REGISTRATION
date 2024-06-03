const staff = document.getElementById("staff");
const student = document.getElementById("student");
const ulabel = document.getElementById("ulabel")
const button = document.getElementById("login");

function onChangeStaff(e){
   ulabel.innerText = "Staff ID / Email";
    button.innerHTML = "Login as Staff";
}

function onChangestudent(e){
    ulabel.innerHTML = "STudent ID / Email";
    button.innerHTML = "Login as Student";
}

staff.addEventListener("change", onChangeStaff);
student.addEventListener("change", onChangestudent);