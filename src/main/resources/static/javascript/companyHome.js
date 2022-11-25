const companiesHTTP = 'http://localhost:8080/api/v1/companies';
const employeesHTTP = 'http://localhost:8080/api/v1/employees';
const projectsHTTP = 'http://localhost:8080/api/v1/projects';

let companyToEditID = localStorage.getItem("companyID");

const corpNametitleHeader = document.querySelector('.corp-name');
const dataCorpId = document.querySelector('#corp-id');
const dataCorpAdress = document.querySelector('#corp-adress');
const dataCorptotalActiveEmps = document.querySelector('#total-active-emps');
const dataCorpActiveProjects = document.querySelector('#corp-active-projects');
const dataCorpFinishedProjects = document.querySelector('#corp-finished-projects');

const addEmpBTN = document.querySelector('#add-emp');
const editEmpBTN = document.querySelector('#edit-emp');
const delEmpBTN = document.querySelector('#del-emp');
const addPrjBTN = document.querySelector('#add-project');
const editPrjBTN = document.querySelector('#edit-project');
const delPrjBTN = document.querySelector('#del-project');

const employeeTable = document.querySelector('.employee-table');
const employeeTableBody = document.querySelector('.employee-table tbody');
const projectTable = document.querySelector('.project-table');
const projectTableBody = document.querySelector('.project-table tbody');

fetch(`${companiesHTTP}/${companyToEditID}`, {
    mode: "cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            setupDataDisplay(data);
            return data;
        })
        .catch(err => console.log(err));

const setupDataDisplay = element => {
    corpNametitleHeader.textContent = element.companyName;
    dataCorpId.textContent = element.id;
    dataCorpAdress.textContent = element.address;
    dataCorptotalActiveEmps.textContent = element.employeeCount;
    dataCorpActiveProjects.textContent = element.ongoingProjectCount;
    dataCorpFinishedProjects.textContent = element.finishedProjectCount;

    localStorage.setItem("companyName", element.companyName);
}  

fetch(`${employeesHTTP}/of/${companyToEditID}`, {
    mode: "cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            for (let employee of data) {
                setUpEmpTable(employee);
            };
            return data;
        })
        .catch(err => console.log(err));

const setUpEmpTable = element => {
    const tableRow = document.createElement('tr');
    employeeTableBody.append(tableRow);
    
    const tableData1 = document.createElement('td');
    const tableData2 = document.createElement('td');
    const tableData3 = document.createElement('td');
    const tableData4 = document.createElement('td');
    const tableData5 = document.createElement('td');
    const tableData6 = document.createElement('td');
    const tableData7 = document.createElement('td');
    tableRow.append(tableData1, tableData2, tableData3, tableData4, tableData5, tableData6, tableData7);

    const radioButton = document.createElement('input');
    tableData1.append(radioButton);

    const wageSpan = document.createElement('span');
    tableData6.append(wageSpan, " €/year");
    
    radioButton.type = "radio";
    radioButton.value = "emp";
    radioButton.id = element.employeeId;
    tableData2.textContent = element.name;
    tableData3.textContent = element.employeeId;
    tableData4.textContent = element.jobTitle;
    tableData5.textContent = element.qualificationCertificateNum;
    wageSpan.textContent = element.salary;
    tableData7.textContent = element.startedWorking;
}  

fetch(`${projectsHTTP}/of/${companyToEditID}`, {
    mode: "cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            for (let project of data) {
                setUpProjTable(project);
            };
            return data;
        })
        .catch(err => console.log(err));

const setUpProjTable = element => {
    const tableRow = document.createElement('tr');
    projectTable.append(tableRow);
    
    const tableData1 = document.createElement('td');
    const tableData2 = document.createElement('td');
    const tableData3 = document.createElement('td');
    const tableData4 = document.createElement('td');
    const tableData5 = document.createElement('td');
    const tableData6 = document.createElement('td');
    const tableData7 = document.createElement('td');
    tableRow.append(tableData1, tableData2, tableData3, tableData4, tableData5, tableData6, tableData7);

    const radioButton = document.createElement('input');
    tableData1.append(radioButton);
    
    radioButton.type = "radio";
    radioButton.name = "proj";
    radioButton.value = element.projectId;

    tableData2.textContent = element.projectName;
    tableData3.textContent = element.employeeId;
    tableData4.textContent = element.projectLocation;
    tableData5.textContent = element.projectStartDate;
    tableData6.textContent = element.ifFinished;
    tableData7.textContent = element.projectManagerId;
}  

let selectedRadioId;



addEmpBTN.addEventListener('click', (e) => {
    console.log(e.target.className); 
    // window.open("addNewEmp.html", '_self');
    window.location.href = "addNewEmp.html";
})

editEmpBTN.addEventListener('click', e => {
    console.log("edit EMP was pressed");
    let employeeRadioButtons = document.querySelector('input[name=emp]:checked').value;
    let projcectRadioButtons = document.querySelector('input[name=proj]:checked').value;

    console.log(employeeRadioButtons, projcectRadioButtons);
})

delEmpBTN.addEventListener('click', e => {
    let employeeRadioButtons = document.querySelector('input[name=emp]:checked').value;
    let projcectRadioButtons = document.querySelector('input[name=proj]:checked').value;

    console.log(employeeRadioButtons, projcectRadioButtons);

})

addPrjBTN.addEventListener('click', () => {
    location.href = "addNewPrj.html";
})

editPrjBTN.addEventListener('click', e => {
    let employeeRadioButtons = document.querySelector('input[name=emp]:checked').value;
    let projcectRadioButtons = document.querySelector('input[name=proj]:checked').value;

    console.log(employeeRadioButtons, projcectRadioButtons);

})

delPrjBTN.addEventListener('click', e => {
    let employeeRadioButtons = document.querySelector('input[name=emp]:checked').value;
    let projcectRadioButtons = document.querySelector('input[name=proj]:checked').value;

    console.log(employeeRadioButtons, projcectRadioButtons);

})

// function iterateRadioBTNS (radioArray, elemType) {
//     for(let element of radioArray) {
//         if (element.checked) {
//             selectedRadioId = element.value;
//             console.log(selectedRadioId);
//             localStorage.setItem(`selectedEmployee${elemType}`, `${selectedRadioId}`);
//         }
//     }    
// }