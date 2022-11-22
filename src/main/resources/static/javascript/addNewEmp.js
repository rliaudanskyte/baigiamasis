const ENDPOINTcompaniesHTTP = 'http://localhost:8080/api/v1/companies';
const ENDPOINTemployeesHTTP = 'http://localhost:8080/api/v1/employees';
const companyForm = document.querySelector('#company-form');
const employeeForm = document.querySelector('#employee-form');
const companyFormTitle = document.querySelector('#company-form-title');
const employeeFormTitle = document.querySelector('#employee-form-title');
const corpNametitleHeader = document.querySelector('.corp-name');
corpNametitleHeader.textContent = localStorage.getItem('companyName');
let companyIdValue = localStorage.getItem("companyID");


class Employee {
    constructor(employeeId, name, jobTitle, certifNum, salary, startedWorking, ifStillWorking, companyId) {
        this.employeeId = employeeId;
        this.name = name;
        this.jobTitle = jobTitle;
        this.certifNum = certifNum;
        this.salary = salary;
        this.startedWorking = startedWorking;
        this.ifStillWorking = ifStillWorking;
        this.companyId = companyId;
        this.stoppedWorking = !ifStillWorking;

    }
    stringifiedPost() {JSON.stringify(this)};
}

employeeForm.addEventListener('submit', (e) => {
    e.preventDefault();
    console.log(companyIdValue);
    const employeeId = e.target.elements.employeeID.value;
    const name = e.target.elements.employeeName.value;
    const jobTitle = e.target.elements.jobTitle.value;
    const certifNum = e.target.elements.certifNum.value;
    const salary = e.target.elements.salary.value;
    const startedWorking = e.target.elements.startedWorking.value;
    const ifStillWorking = e.target.elements.ifStillWorking.value;
    const companyId = companyIdValue;

    const newEmp = new Employee(employeeId, name, jobTitle, certifNum, salary, startedWorking, ifStillWorking, companyId);
    
    console.table(newEmp);
    postEmployeeToServer(newEmp);

    document.querySelector('#congrats').style.display = "block";
    employeeForm.style.display = "none";
})

const postEmployeeToServer = (obj) => {    
    fetch(ENDPOINTemployeesHTTP, {
        method: 'POST',
        mode: "cors",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            employeeId: obj.employeeId,
            name: obj.name,
            jobTitle: obj.jobTitle,
            qualificationCertificateNum: obj.certifNum,
            salary: obj.salary,
            startedWorking: obj.startedWorking,
            ifStillWorking: obj.ifStillWorking,
            companyId: obj.companyId,
            stoppedWorking: obj.stoppedWorking
        })
    })
    .then(res => {
        return res.json()
    })
    .then(data => {
        console.table(data);
        corpNametitleHeader.textContent = data.companyName;
    })
    .catch(err => console.log(err))
} 