/*
    Different ways of accessing elements
*/
var elementsWithClassRev = document.getElementsByClassName('rev');
var helloSpan = elementsWithClassRev[0];

var spanElements = document.getElementsByTagName('span');
helloSpan = spanElements[0];

helloSpan = document.getElementById('hello');

var clickMeButton = document.getElementsByTagName('button')[0];

/*
    Manipulating the DOM: Changing Elements
*/
// Adding event listener.
clickMeButton.onclick = changeHelloSpan;

function changeHelloSpan() {
    // Generates a random font size.
    var randomSize = (Math.floor(Math.random() * 30)) + 10;

    // Generates a random color.
    var hexcode = '#';
    for (var i = 0; i < 6; i++) {
        var letterOrNumber = Math.floor(Math.random() * 2);
        if (letterOrNumber === 0)
            hexcode += '' + Math.floor(Math.random() * 10);
        else {
            hexcode += '' + String.fromCharCode(Math.floor(Math.random() * 6) + 65);
        }
    }

    // Generates a "random" message.
    var message = '';
    switch (Math.floor(Math.random() * 3)) {
        case 0:
            message = 'Hello world!';
            break;
        case 1:
            message = 'Revature';
            break;
        case 2:
            message = 'JavaScript is great!';
            break;
    }

    // Sets the span's color and size to the randomized values.
    helloSpan.style = 'color:' + hexcode + ';font-size:' + randomSize;
    // Sets the span's text to the random message.
    // helloSpan.innerHTML = message;
    helloSpan.innerHTML = `<strong>
        ${message}!
    </strong>`;
}

/*
    Event Propagation
*/
var divA = document.getElementById('A');
var divB = document.getElementById('B');
var divC = document.getElementById('C');
var divD = document.getElementById('D');
var divE = document.getElementById('E');
var propagationHeading = document.getElementsByTagName('span')[1];
var propagationSwitchBtn = document.getElementsByTagName('button')[1];
propagationSwitchBtn.onclick = switchPropagation;
var capturing = false;
addListenersToDivs();

function switchPropagation() {
    removeListenersFromDivs();
    capturing = !capturing;
    if (capturing) {
        propagationSwitchBtn.innerHTML = 'Bubble';
        propagationHeading.innerHTML = 'Capturing';
    } else {
        propagationSwitchBtn.innerHTML = 'Capture';
        propagationHeading.innerHTML = 'Bubbling';
    }
    addListenersToDivs();
}

function addListenersToDivs() {
    divA.addEventListener('mouseover', selectDiv, capturing);
    divA.addEventListener('mouseout', deselectDiv, capturing);
    divB.addEventListener('mouseover', selectDiv, capturing);
    divB.addEventListener('mouseout', deselectDiv, capturing);
    divC.addEventListener('mouseover', selectDiv, capturing);
    divC.addEventListener('mouseout', deselectDiv, capturing);
    divD.addEventListener('mouseover', selectDiv, capturing);
    divD.addEventListener('mouseout', deselectDiv, capturing);
    divE.addEventListener('mouseover', selectDiv, capturing);
    divE.addEventListener('mouseout', deselectDiv, capturing);
}

function removeListenersFromDivs() {
    divA.removeEventListener('mouseover', selectDiv, capturing);
    divA.removeEventListener('mouseout', deselectDiv, capturing);
    divB.removeEventListener('mouseover', selectDiv, capturing);
    divB.removeEventListener('mouseout', deselectDiv, capturing);
    divC.removeEventListener('mouseover', selectDiv, capturing);
    divC.removeEventListener('mouseout', deselectDiv, capturing);
    divD.removeEventListener('mouseover', selectDiv, capturing);
    divD.removeEventListener('mouseout', deselectDiv, capturing);
    divE.removeEventListener('mouseover', selectDiv, capturing);
    divE.removeEventListener('mouseout', deselectDiv, capturing);
}

function selectDiv() {
    this.style.borderTop = '2px solid orange';
    console.log(this.id);
}

function deselectDiv() {
    this.style.border = 'none';
}

/*
    Manipulating the DOM: Creating Elements
*/
var createTableBtn = document.getElementsByTagName('button')[2];
var tableDiv = document.getElementById('tableDiv');

createTableBtn.onclick = createTable;

function createTable() {
    createTableBtn.removeEventListener('click', createTable);

    var table = document.createElement('table');
    var rows = (Math.floor(Math.random() * 9)) + 1;
    var cols = (Math.floor(Math.random() * 9)) + 1;
    for (var i = 0; i < rows; i++) {
        var tr;
        tr = document.createElement('tr');
        for (var j = 0; j < cols; j++) {
            var td;
            if (i === 0) td = document.createElement('th');
            else td = document.createElement('td');
            td.innerHTML = j;
            tr.appendChild(td);
        }
        
        table.appendChild(tr);
    }
    tableDiv.appendChild(table);

    createTableBtn.innerHTML = 'Remove Table';
    createTableBtn.onclick = removeTable;
}

function removeTable() {
    createTableBtn.removeEventListener('click', removeTable);
    tableDiv.innerHTML = '';
    createTableBtn.innerHTML = 'Create Table';
    createTableBtn.onclick = createTable;
}