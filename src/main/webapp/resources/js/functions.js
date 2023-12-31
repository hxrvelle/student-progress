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

function setSelectedOption() {
    let activeDiscipline = document.getElementsByClassName("activeDiscipline");
    let allDiscipline = document.getElementsByClassName("allDisciplines");

    for (i = 0; i < allDiscipline.length; i++) {
        let dis = allDiscipline[i];
        for (j = 0; j < activeDiscipline.length; j++) {
            let aDis = activeDiscipline[j];
            if (dis.text == aDis.text) {
                dis.setAttribute("selected", true)
            }
        }
    }
}

function setIdDiscipline() {
    let disIds = document.getElementsByName("disciplineIds");
    let markCells = document.getElementsByName("disciplineId");

    for (i = 0; i < disIds.length; i++) {
        let disId = disIds[i].value;
        let markCell = markCells[i];
        markCell.setAttribute("value", disId);
    }

    let inputs = document.getElementsByName("markCell");
    let disciplines = document.getElementsByName("disciplineIds");
    let selected = document.getElementsByName("selectedDis");

    inputs.forEach((item, index) => {
        let i = (`${index}`);
        if (inputs[i].innerHTML.includes("button")) {
            let input = document.getElementsByName("mark");
            if (input[i] != undefined) {
                input[i].addEventListener("click", myFunction);
                function myFunction() {
                    let dis = disciplines[i].value;
                    selected[0].setAttribute("value", dis);
                }
            } else {
                input[0].addEventListener("click", myFunction);
                function myFunction() {
                    let dis = disciplines[i].value;
                    selected[0].setAttribute("value", dis);
                }
            }
        }
    });
}