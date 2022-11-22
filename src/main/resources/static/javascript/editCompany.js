const ENDPOINTcompaniesHTTP = 'http://localhost:8080/api/v1/companies';

const companyForm = document.querySelector('#company-form');
const inputName = document.querySelector('input[id=companyName]');
const inputCompanyAddress = document.querySelector('input[id=companyAddress]');
const succsessMessage = document.querySelector('#congrats');
const companyToEditID = localStorage.getItem("companyID");

fetch(`${ENDPOINTcompaniesHTTP}/${companyToEditID}`, {
    mode: "cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            setupForm(element);
            return data;
        })
        .catch(err => console.log(err));

const setupForm = element => {
    inputName.value = element.companyName;
    inputCompanyAddress.value = element.address;
}        

class Company {
    constructor(companyName, address) {
        this.companyName = companyName;
        this.address = address;
        this.employeeCount = 1;
        this.totalProjects = 1;
        this.ongoingProjectCount = 1;
        this.finishedProjectCount = 1;
    }
    stringifiedPost() {JSON.stringify(this)};
}

companyForm.addEventListener('submit', (e) => {
    e.preventDefault();
    const companyName = inputName.value;
    const companyAddress = inputCompanyAddress.value
    const newCorp = new Company(companyName, companyAddress);
    console.table(newCorp);
    putCompanyToServer(newCorp);

    document.querySelector('#congrats').style.display = "block";
    companyForm.style.display = "none";
})

const putCompanyToServer = (obj) => {    
    fetch(`${ENDPOINTcompaniesHTTP}/${companyToEditID}` , {
        method: 'PUT',
        mode: "cors",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({            
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