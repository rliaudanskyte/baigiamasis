const ENDPOINTcompanies = '../local_json_files/companies';
const ENDPOINTemployees = '../local_json_files/employees';
const ENDPOINTprojects = '../local_json_files/pprojects';
const companiesHTTP = 'http://localhost:8080/api/v1/companies';
const employeesHTTP = 'http://localhost:8080/api/v1/employees';
const projectsHTTP = '.http://localhost:8080/api/v1/pprojects';

const addEmpBTN = document.querySelector('.add-emp');
const editEmpBTN = document.querySelector('.edit-emp');
const delEmpBTN = document.querySelector('.del-emp');
const addPrjBTN = document.querySelector('.add-project');
const editPrjBTN = document.querySelector('.edit-project');
const delPrjBTN = document.querySelector('.del-project');

