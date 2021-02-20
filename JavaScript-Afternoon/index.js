let student ={
    
};

let students = [];

function store(){
    
    student.firstname = document.getElementById("fname").value;
    student.lastname = document.getElementById("lname").value;
    student.age = document.getElementById("age").value;
    //student.gender = document.getElementByName("gender").value;
    student.gender = document.getElementById("male").checked ? "Male" :"Female";
    student.rollno = document.getElementById("roll").value;
    student.dob = document.getElementById("dob").value;
    student.occupation = document.getElementById("occ").value;
   // students.push(student);
    console.log(student);
    //student ={};
}

function retrieve(){

    let roll = document.getElementById("rno").value;
    if(student.rollno===roll){
       // console.log(student);
        document.getElementById("details").innerHTML = `
        
        Details of student are: <br>
        Name : ${student.firstname}  ${student.lastname} <br>
        Occupation : ${student.occupation} <br>
        Age : ${student.age} <br>
        Gender : ${student.gender} <br>
        DOB : ${student.dob} <br>

        `;
    }
    else{
        document.getElementById("details").innerHTML = "No details found"+"<br>";
        console.log("No details found");
    }
    
}

