const lightsaberSelectButton = document.querySelector("#lightsaber-select-button");
const avengersSelectButton = document.querySelector("#avengers-select-button");
const fellowshipSelectButton = document.querySelector("#fellowship-select-button");
const headerBrandContainer = document.querySelector(".header-brand-container");
const corpButtons = document.querySelector(".corp-buttons");
const tableBody = document.querySelector("#t-body");
const ENDPOINT = 'http://localhost:8080/companies'

// add event listeners for corp-buttons
// flex-dirrection to row
// corp-buttons remove
// header-brand-container display

lightsaberSelectButton.addEventListener('click', () => {
    fixedElementVisuals();
    document.querySelector('.corp-name').textContent = "The Lightsaber company";
    fetch(ENDPOINT)
        .then(data => data.json())
        .then(data => {
            console.table(data);
            data.forEach(element => createTableDataFunction(element));
        });
});

function createTableDataFunction(element) {
    const tableRow = document.createElement('tr');
    tableBody.append(tableRow);

    const tableData1 = document.createElement('td');
    const tableData2 = document.createElement('td');
    const tableData3 = document.createElement('td');
    const tableData4 = document.createElement('td');
    const tableData5 = document.createElement('td');
    const tableData6 = document.createElement('td');
    const tableData7 = document.createElement('td');
    const tableData8 = document.createElement('td');

    tableRow.append(
        tableData1,
        tableData2,
        tableData3,
        tableData4,
        tableData5,
        tableData6,
        tableData7,
        tableData8
    );

    tableData1.textContent = element.id;
    tableData2.textContent = element.companyName;
    tableData3.textContent = element.address;
    tableData4.textContent = element.employeeCount;
    tableData5.textContent = element.averageSalary;
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