/*
    Closure
*/

// Basic Closure
function hasVar() {
    var privateVar = 'This variable acts as if it is encapsulated.';
    return function () {
        // This function has closure to privateVar.
        return privateVar;
    }
}

var hasClosure = hasVar();
console.log(hasClosure());

// Mimicking Encapsulation
function encapsulated() {
    var id = 1;
    var name = 'Revature';
    return {
        'getId':function () {
            return id;
        },
        'setId':function (newId) {
            if (typeof newId === 'number' && newId > 0) {
                id = newId;
            }
        },
        'getName':function () {
            return name;
        },
        'setName':function (newName) {
            name = newName;
        }
    }
}

var myObj = encapsulated();
console.log(myObj.getId());
console.log(myObj.getName());
myObj.setId(2);
myObj.setId('five'); // These show the use of the check in the function.
myObj.setId(0); // These show the use of the check in the function.
myObj.setName('Hello');
console.log(myObj.getId());
console.log(myObj.getName());

var obj2 = encapsulated();
console.log(obj2.getId());
console.log(obj2.getName());
console.log(myObj.getId());
console.log(myObj.getName());

/*
    Prototyping
*/

var Parent = function () {
    this.id = 1;
    this.name = 'Revature';
    this.sayHello = function () {
        console.log('Hello');
    }
}

console.log(Parent);
var parentObj = new Parent();
console.log(parentObj);
console.log('parentObj is a Parent? ' + (parentObj instanceof Parent)); // True
parentObj.sayHello();

var Child = function () {
    this.name = 'Training';
    this.sayHello = function () {
        console.log('Hello world!');
    }
}

Child.prototype = new Parent();
Child.prototype.constructor = Child;

var childObj = new Child();
console.log(childObj);
childObj.sayHello();
childObj.__proto__.sayHello();

console.log('childObj is a Child? ' + (childObj instanceof Child)); // True
console.log('childObj is a Parent? ' + (childObj instanceof Parent)); // True

var GrandChild = function () {
    this.sayHello = function () {
        console.log("Hello again");
    }
}

GrandChild.prototype = new Child();
GrandChild.prototype.constructor = GrandChild;
var grandChild = new GrandChild();
grandChild.sayHello();
grandChild.__proto__.sayHello();
grandChild.__proto__.__proto__.sayHello();

console.log('grandChild is a GrandChild? ' + (grandChild instanceof GrandChild));
console.log('grandChild is a Child? ' + (grandChild instanceof Child)); // True
console.log('grandChild is a Parent? ' + (grandChild instanceof Parent)); // True