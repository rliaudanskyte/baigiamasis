const ENDPOINTcompanies = '../local_json_files/companies';
const ENDPOINTtest = 'https://formsubmit.co/rliaudanskyte@gmail.com';
const ENDPOINTcompaniesHTTP = 'http://localhost:8080/api/v1/companies';
const ENDPOINTemployees = '../local_json_files/employees';
const ENDPOINTprojects = '../local_json_files/pprojects';
const form = document.querySelector('form');

class Company {
    constructor(companyName, id, address) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.employeeCount = 1;
        this.averageSalary = 1;
        this.totalProjects = 1;
        this.ongoingProjectCount = 1;
        this.finishedProjectCount = 1;
    }
    stringifiedPost() {JSON.stringify(this)};
}

form.addEventListener('submit', (e) => {
     e.preventDefault();
    const companyName = e.target.elements.companyName.value;
    console.log(typeof(companyName));
    const companyID = e.target.elements.companyID.value;
    const companyAddress = e.target.elements.companyAddress.value;
    const newCorp = new Company(companyName, companyID, companyAddress);
    postToServer(newCorp);
})

const postToServer = (obj) => {    
    fetch(ENDPOINTcompaniesHTTP, {
        method: 'POST',
        mode: "no-cors",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: obj.id,
            companyName: obj.companyName,
            address: obj.address,
            employeeCount: obj.employeeCount,
            averageSalary: obj.averageSalary,
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