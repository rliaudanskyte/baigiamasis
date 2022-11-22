const corpButtonsContainer = document.querySelector(".corp-buttons");
let cookie = document.cookie;
// const ENDPOINT = '../local_json_files/companies.json';
const ENDPOINT = 'http://http://localhost:8080/api/v1/companies';

sessionStorage.clear();

fetch(ENDPOINT, {
    mode: "no-cors"
})
    .then(data => data.json())
    .then(data => {
        console.table(data);
        data.forEach( element => createButtons(element));
        return data;
    })
    .catch(err => console.log(err));

const createButtons = (element) => {
    const divButtonBox = document.createElement('div');
    divButtonBox.className = "button-box";
    corpButtonsContainer.append(divButtonBox);

    // Slide OUT BUTTONS
    const divContainerForSlideOut = document.createElement('div');
    divContainerForSlideOut.className = "buttons-slide-out";
    divButtonBox.append(divContainerForSlideOut);

    const editBTN = document.createElement('button');
    editBTN.className = "action-button";
    divContainerForSlideOut.append(editBTN);

    const aLinkToEdit = document.createElement('a');
    aLinkToEdit.classList = "edit button-link";
    aLinkToEdit.href = "#"; //todo: ADD LINK
    editBTN.append(aLinkToEdit);

    const editIcon = document.createElement('i');
    editIcon.className = "fa-solid fa-pen";
    aLinkToEdit.append(editIcon);
    
    const delBTN = document.createElement('button');
    delBTN.className = "action-button";
    divContainerForSlideOut.append(delBTN);

    const aLinkToDel = document.createElement('a');
    aLinkToDel.classList = "del button-link";
    aLinkToDel.href = "#";  //todo: ADD LINK
    delBTN.append(aLinkToDel);

    const delIcon = document.createElement('i');
    delIcon.className = "fa-solid fa-trash";
    aLinkToDel.append(delIcon);


    // COMPANY button
    
    const divForButton = document.createElement('div');
    divForButton.className = "buttons-with-company-name";
    divButtonBox.append(divForButton);

    const corpButton = document.createElement('button');
    corpButton.className = "corp-button";
    divForButton.append(corpButton);

    const aLinkToCompany = document.createElement('a');
    aLinkToCompany.classList = "del button-link";
    // aLinkToCompany.href = "html\\companyHome.html";  
    aLinkToCompany.textContent = element.companyName;
    corpButton.append(aLinkToCompany);

}

let btns = document.querySelectorAll('.corp-button');

for (i of btns) {
  (function(i) {
    i.addEventListener('click', function() {
      console.log(i);
    });
  })(i);
}
