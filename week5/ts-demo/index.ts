console.log('Hello World!');

// implicitely assigns myVar to a string
let myVar = 'my Var!';

// cannot reassign a string to a boolean
// myVar = true;

let myNum: number = 5;

enum colors{
    BLUE, GREEN, RED
}

let myEnum:colors = colors.BLUE;

console.log(myEnum);

interface myInterface{
    myVar: string;
}

class myClass implements myInterface{
    private _myVar: string;

    constructor(someVar: string){
        this._myVar = someVar;
    }

    get myVar(){
        return this._myVar;
    }
}