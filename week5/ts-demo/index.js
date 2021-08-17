console.log('Hello World!');
// implicitely assigns myVar to a string
let myVar = 'my Var!';
// cannot reassign a string to a boolean
// myVar = true;
let myNum = 5;
var colors;
(function (colors) {
    colors[colors["BLUE"] = 0] = "BLUE";
    colors[colors["GREEN"] = 1] = "GREEN";
    colors[colors["RED"] = 2] = "RED";
})(colors || (colors = {}));
let myEnum = colors.BLUE;
console.log(myEnum);
class myClass {
    constructor(someVar) {
        this._myVar = someVar;
    }
    get myVar() {
        return this._myVar;
    }
}
