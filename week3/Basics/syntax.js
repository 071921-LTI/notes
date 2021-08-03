// Line Comments

/*
    Block Comments
*/

//"use strict"; // See line 83.

/* Functions */
function helloLog() {
    console.log('Hello from helloLog!');
}

function logMessage(message) {
    console.log(message);
}

helloLog();
logMessage('Hello from the logMessage argument!');
logMessage(1234567890);
logMessage(20 / 5);
logMessage(8 == '8'); // True (type coercion)
logMessage(8 === '8'); // False
logMessage(null);
var m; // Undefined
logMessage(m);

function logMessageFromInput() {
    /* JavaScript is dynamically-typed. */
    var message = 5;
    message = true;
    message = document.getElementById('messageInput').value;
    console.log(message);
}

var logBtn = document.getElementById('logBtn');
/* Two different ways of adding an event listener */
logBtn.addEventListener('click', logMessageFromInput);
//logBtn.onclick = logMessageFromInput;

/* Objects and Arrays */
var obj = {
    'id':1,
    'name':'Revature',
    'favoriteColor':'orange',
    'isObject':true
};
var arr = [1, 'Revature', 'orange', true];

console.log(obj);
console.log(arr);
console.log(typeof obj + ', ' + typeof arr);

var obj2 = {
    'firstName':'Hello',
    'lastName':'World',
    'fullName':function() {
        console.log(this.firstName + ' ' + this.lastName);
    }
}

obj2.fullName();
obj2.firstName = 'Goodbye';
obj2.fullName();

/* Scopes */
var globalVar = 'I\'m a global-scope variable.';

function myFunction() {
    var functionVar = 'I\'m a function-scope variable.'

    /* ES6+ added block scope. */
    if (true) {
        let blockVar = 'I\'m a block-scope variable.';
        const blockConst = 'I\'m also a block-scope variable.';
        // blockConst = 'something else'; // throws an error
    }

    funcitonVar = ''; // will throw an error in strict mode

    console.log(functionVar);
    //var functionVar = 'I\'m a function-scope variable.'
}

/* Immediately Invoked Function Expression */
(function () { console.log('Hello from the IIFE')})();
var returnVal = (function () { return 'IIFE result'})();
console.log(returnVal);

x = "Hello"; // If "use strict" is used at the top of the file, this will throw an error in the console.
myFunction(); // will throw an error in strict mode (line 79)