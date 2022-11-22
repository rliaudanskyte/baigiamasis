const ENDPOINTcompaniesHTTP = 'http://localhost:8080/api/v1/companies';
const ENDPOINTprojectsHTTP = 'http://localhost:8080/api/v1/projects';
const companyForm = document.querySelector('#company-form');
const projectForm = document.querySelector('#project-form');
const companyFormTitle = document.querySelector('#company-form-title');
const projectFormTitle = document.querySelector('#project-form-title');
const corpNametitleHeader = document.querySelector('.corp-name');
corpNametitleHeader.textContent = localStorage.getItem('companyName');
let companyIdValue = localStorage.getItem("companyID");


class Project {
    constructor(projectId, projectName, projectLocation, projectStartDate, ifFinished, projectManagerId) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectLocation = projectLocation;
        this.projectStartDate = projectStartDate;
        this.ifFinished = ifFinished;
        this.projectManagerId = projectManagerId;
        this.companyExecutiveId = companyIdValue;
    }
    stringifiedPost() {JSON.stringify(this)};
}

projectForm.addEventListener('submit', (e) => {
    e.preventDefault();
    console.log(companyIdValue);

    const projectId = e.target.elements.projectId;
    const projectName = e.target.elements.projectName;
    const projectLocation = e.target.elements.projectLocation;
    const projectStartDate = e.target.elements.projectStartDate;
    const ifFinished = e.target.elements.ifFinished;
    const projectManagerId = e.target.elements.projectManagerId;
    const companyExecutiveId = companyIdValue;

    const newProj = new Project(projectId, projectName, projectLocation, projectStartDate, ifFinished, projectManagerId);
    
    console.table(newProj);
    postProjectToServer(newProj);

    document.querySelector('#congrats').style.display = "block";
    projectForm.style.display = "none";
})

const postProjectToServer = (obj) => {    
    fetch(ENDPOINTprojectsHTTP, {
        method: 'POST',
        mode: "cors",
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            projectId: obj.projectId,
            projectName: obj.projectName,
            projectLocation: obj.projectLocation,
            projectStartDate: obj.projectStartDate,
            ifFinished: obj.ifFinished,
            projectManagerId: obj.projectManagerId,
            companyExecutiveId: obj.companyExecutiveId
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