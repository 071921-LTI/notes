describe('Basic Test', ()=>{
    it('should be false', ()=>{
        /*
            AAA:
            Arrange
            Act
            Assert
        */
       let sut = true;

        sut = false;

        expect(sut).toBeFalse();
    })

    it('should be 4',() =>{
        // Arrange
        let x = 2;
        let y = 5;
        let z;

        //Act
        z = x + y;

        //Assert
        expect(z).toEqual(4);
    })
})