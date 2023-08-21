function setSelected() {
    let dropdown = document.getElementsByClassName("period");
    let option = document.getElementsByClassName("data-option");
    let index = dropdown[0].selectedIndex;
    if (index !== 0) {
        option[index].setAttribute("selected", "true");
        let optionValue = option[index].innerHTML;
        dropdown[0].setAttribute("value", optionValue);
    } else if (index === 0) {
        dropdown[0].removeAttribute("value");
    }
    for (let i = 0; i < option.length; i++) {
        if (option[i] !== option[index]) {
            option[i].removeAttribute("selected");
        }
    }
    //let selectedOption = document.querySelector("[selected='true']").getAttribute("id");
}
function deleteStudents() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idStud]:checked');
    if(checkedCheckboxes.length === 0) {
        alert("Выберите студента");
        return;
    }
    let ids = "";
    for(let i = 0; i < checkedCheckboxes.length; i++) {
        ids = ids + checkedCheckboxes[i].value + " ";
    }
    document.getElementById("idsToDeleteHidden").value = ids;
    document.getElementById('formDelete').submit();
}
function modifyStudent() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idStud]:checked');
    if(checkedCheckboxes.length === 0) {
        alert("Выберите студента");
        return;
    }
    if (checkedCheckboxes.length > 1) {
        alert("Выберите одного студента");
        return;
    }

    let id = checkedCheckboxes[0].value;

    document.getElementById("idToModifyHidden").value = id;
    document.getElementById('formModify').submit();
}
function progressStudent() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idStud]:checked');
    if(checkedCheckboxes.length === 0) {
        alert("Выберите студента");
        return;
    }
    if (checkedCheckboxes.length > 1) {
        alert("Выберите одного студента");
        return;
    }

    let id = checkedCheckboxes[0].value;

    document.getElementById("idToProgressHidden").value = id;
    document.getElementById('formProgress').submit();
}

function modifyDiscipline() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idDisc]:checked');
    if(checkedCheckboxes.length === 0) {
        alert("Выберите дисциплину");
        return;
    }
    if (checkedCheckboxes.length > 1) {
        alert("Выберите одну дисциплину");
        return;
    }

    let id = checkedCheckboxes[0].value;

    document.getElementById("idToModifyHidden").value = id;
    document.getElementById('formModify').submit();
}

function deleteDiscipline() {
    let checkedCheckboxes = document.querySelectorAll('input[name=idDisc]:checked');
    if(checkedCheckboxes.length === 0) {
        alert("Выберите дисциплину");
        return;
    }
    let ids = "";
    for(let i = 0; i < checkedCheckboxes.length; i++) {
        ids = ids + checkedCheckboxes[i].value + " ";
    }
    document.getElementById("idsToDeleteHidden").value = ids;
    document.getElementById('formDelete').submit();
}