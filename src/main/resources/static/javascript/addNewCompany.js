const ENDPOINTcompanies = '../local_json_files/companies';
const ENDPOINTtest = 'https://formsubmit.co/rliaudanskyte@gmail.com';
const ENDPOINTcompaniesHTTP = 'http://localhost:8080/api/v1/companies';
const ENDPOINTemployeesHTTP = 'http://localhost:8080/api/v1/employees';
const ENDPOINTemployees = '../local_json_files/employees';
const ENDPOINTprojects = '../local_json_files/projects';
const companyForm = document.querySelector('#company-form');
const employeeForm = document.querySelector('#employee-form');
const companyFormTitle = document.querySelector('#company-form-title');
const employeeFormTitle = document.querySelector('#employee-form-title');
let companyIdValue; 

class Company {
    constructor(companyName, id, address) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.employeeCount = 1;
        this.totalProjects = 1;
        this.ongoingProjectCount = 1;
        this.finishedProjectCount = 1;
    }
    stringifiedPost() {JSON.stringify(this)};
}
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


companyForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const companyName = e.target.elements.companyName.value;
    const companyID = e.target.elements.companyID.value;
    const companyAddress = e.target.elements.companyAddress.value;
    const newCorp = new Company(companyName, companyID, companyAddress);
    companyIdValue = e.target.elements.companyID.value;
    console.table(newCorp);
    postCompanyToServer(newCorp);

    companyFormTitle.style.display = "none";
    employeeFormTitle.style.display = "block";
    companyForm.style.display = "none";
    employeeForm.style.display = "flex";
})

const postCompanyToServer = (obj) => {    
    fetch(ENDPOINTcompaniesHTTP, {
        method: 'POST',
        mode: "cors",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: obj.id,
            companyName: obj.companyName,
            address: obj.address,
            employeeCount: obj.employeeCount,
            totalProjects: obj.totalProjects,
            ongoingProjectCount: obj.ongoingProjectCount,
            finishedProjectCount: obj.finishedProjectCount
        })
    })
    .then(res => {
        return res.json()
    })
    .then(data => {
        console.table(data);
    })
    .catch(err => console.log(err))
} 


employeeForm.addEventListener('submit', (e) => {
    e.preventDefault();
    console.log(companyIdValue);
    const employeeId = target.elements.employeeID.value;
    const name = target.elements.employeeName.value;
    const jobTitle = target.elements.jobTitle.value;
    const certifNum = target.elements.certifNum.value;
    const salary = target.elements.salary.value;
    const startedWorking = target.elements.startedWorking.value;
    const ifStillWorking = target.elements.ifStillWorking.value;
    const companyId = companyIdValue;

    const newCorp = new Employee(employeeId, name, jobTitle, certifNum, salary, startedWorking, ifStillWorking, companyId);
    
    console.table(newCorp);
    postEmployeeToServer(newCorp);

    document.querySelector('#congrats').style.display = "block";
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
    })
    .catch(err => console.log(err))
} 