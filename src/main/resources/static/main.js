const lightsaberSelectButton = document.querySelector("#lightsaber-select-button");
const avengersSelectButton = document.querySelector("#avengers-select-button");
const fellowshipSelectButton = document.querySelector("#fellowship-select-button");
const headerBrandContainer = document.querySelector(".header-brand-container");
const corpButtons = document.querySelector(".corp-buttons");
const tableBody = document.querySelector("#t-body");
const ENDPOINT = 'http://localhost:8080/api/v1/companies'

// flex-dirrection to row
// corp-buttons remove
// header-brand-container display

lightsaberSelectButton.addEventListener('click', () => {
    fixedElementVisuals();
    document.querySelector('.corp-name').textContent = "The Lightsaber company";
    fetch(ENDPOINT, {
        mode: "no-cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            const singleCompanyData = data.filter(element => element.companyName === "The Lightsaber company" );
            return singleCompanyData;
        })
        .then(singleCompanyData => createTableDataFunction(singleCompanyData[0]))
        .catch(err => console.log(err));
});

avengersSelectButton.addEventListener('click', () => {
    fixedElementVisuals();
    document.querySelector('.corp-name').textContent = "The Avengers corp";
    fetch(ENDPOINT, {
        mode: "no-cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            const singleCompanyData = data.filter(element => element.companyName === "The Avengers corp" );
            return singleCompanyData;
        })
        .then(singleCompanyData => createTableDataFunction(singleCompanyData[0]))
        .catch(err => console.log(err));
});

fellowshipSelectButton.addEventListener('click', () => {
    fixedElementVisuals();
    document.querySelector('.corp-name').textContent = "The Fellowship Inc";
    fetch(ENDPOINT, {
        mode: "no-cors"
    })
        .then(data => data.json())
        .then(data => {
            console.table(data);
            const singleCompanyData = data.filter(element => element.companyName === "The Fellowship Inc" );
            return singleCompanyData;
        })
        .then(singleCompanyData => createTableDataFunction(singleCompanyData[0]))
        .catch(err => console.log(err));
});

function createTableDataFunction(element) {
    const tableDataElements = [];
    const tableRow = document.createElement('tr');
    Object.assign(tableRow.style, {
        borderBottom: '1px solid black'
    })
    tableBody.append(tableRow);

    const tableData1 = document.createElement('td');
    const tableData2 = document.createElement('td');
    const tableData3 = document.createElement('td');
    const tableData4 = document.createElement('td');
    const tableData5 = document.createElement('td');
    const tableData6 = document.createElement('td');
    const tableData7 = document.createElement('td');
    const tableData8 = document.createElement('td');

    tableDataElements.push(tableData1, tableData2, tableData3, tableData4, tableData5, tableData6, tableData7, tableData8);

    tableDataElements.forEach(element => {
        Object.assign(element.style, {
            padding: "10px",
            textAlign: "center"
        })
        tableRow.append(element);
    });

    tableData1.textContent = element.id;
    tableData2.textContent = element.companyName;
    tableData3.textContent = element.address;
    tableData4.textContent = element.employeeCount;
    tableData5.textContent = element.averageSalary.toFixed(2);
    tableData6.textContent = element.totalProjects;
    tableData7.textContent = element.ongoingProjectCount;
    tableData8.textContent = element.finishedProjectCount;
}

function fixedElementVisuals() {
    headerBrandContainer.style.display = "block";
    corpButtons.style.display = "none";
    document.querySelector('.header-text-container > h1').style.textAlign = "left";
    document.querySelector('.header-brand-container > h1').style.textAlign = "right";
    document.querySelector('header').style.flexDirection = "row";
    document.querySelector('header').style.justifyContent = "space-between";
    document.querySelector('.display-table').style.display = "block";
}