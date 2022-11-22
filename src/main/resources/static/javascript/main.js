const corpButtonsContainer = document.querySelector(".corp-buttons");
let cookie = document.cookie;
const ENDPOINT = '../local_json_files/companies.json';
const ENDPOINTcompaniesHTTP = 'http://localhost:8080/api/v1/companies';
let companyIDToLS;

sessionStorage.clear();

// fetch(ENDPOINT, {
fetch(ENDPOINTcompaniesHTTP, {
    mode: "cors"
})
    .then(data => data.json())
    .then(data => {
      console.table(data);
      for (let element of data) {
        createButtons(element);
      }
      return data;
    })
    .catch(err => console.log(err));

const createButtons = (element) => {
    const divButtonBox = document.createElement('div');
    divButtonBox.className = "button-box";
    divButtonBox.id = element.id;
    corpButtonsContainer.append(divButtonBox);

    // Slide OUT BUTTONS
    const divContainerForSlideOut = document.createElement('div');
    divContainerForSlideOut.className = "buttons-slide-out";
    divButtonBox.append(divContainerForSlideOut);

    const editBTN = document.createElement('button');
    editBTN.className = "action-button-edit";
    divContainerForSlideOut.append(editBTN);

    const aLinkToEdit = document.createElement('a');
    aLinkToEdit.classList = "edit button-link";
    aLinkToEdit.href = "editCorp.html";
    editBTN.append(aLinkToEdit);

    const editIcon = document.createElement('i');
    editIcon.className = "fa-solid fa-pen";
    editIcon.id = "edit-icon";
    aLinkToEdit.append(editIcon);
    
    const delBTN = document.createElement('button');
    delBTN.className = "action-button-del";
    divContainerForSlideOut.append(delBTN);

    const aLinkToDel = document.createElement('a');
    aLinkToDel.classList = "del button-link";
    aLinkToDel.href = "#";  //todo: ADD LINK
    delBTN.append(aLinkToDel);

    const delIcon = document.createElement('i');
    delIcon.className = "fa-solid fa-trash";
    delIcon.id = "delete-icon";
    aLinkToDel.append(delIcon);


    // COMPANY button
    
    const divForButton = document.createElement('div');
    divForButton.className = "buttons-with-company-name";
    divButtonBox.append(divForButton);

    const corpButton = document.createElement('button');
    corpButton.className = "corp-button";
    divForButton.append(corpButton);

    const aLinkToCompany = document.createElement('a');
    aLinkToCompany.classList = "button-link";
    aLinkToCompany.id = "button-link";
    aLinkToCompany.href = "companyHome.html";
    aLinkToCompany.textContent = element.companyName;
    corpButton.append(aLinkToCompany);

}

document.body.addEventListener('click', event => {
  if (event.target.nodeName == "A") {
    companyIDToLS = event.target.parentNode.parentNode.parentNode.id;
    localStorage.setItem("companyID", companyIDToLS);
    if (event.target.parentNode.className == "action-button-del") {
      deleteCompanyById(companyIDToLS);
    }
    if (event.target.parentNode.className == "action-button-edit") {
      location.href = "editCorp.html";
    }
  }
  if (event.target.nodeName == "BUTTON") {
    companyIDToLS = event.target.parentNode.parentNode.id;
    localStorage.setItem("companyID", companyIDToLS);
    if (event.target.className == "action-button-del") {
      deleteCompanyById(companyIDToLS);
    }
    if (event.target.className == "action-button-edit") {
      location.href = "editCorp.html";
    }
  }
  if (event.target.id == "add-new") {
    location.href='addNewCorp.html';
  }
})

const deleteCompanyById = companyToDeleteID => {
  fetch(`${ENDPOINTcompaniesHTTP}/${companyToDeleteID}`, {
    method: 'DELETE',
    mode: "cors"
  })
  .then(res => res.json())
  .then(data => {
    window.location.reload(true);
  });
}