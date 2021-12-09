function getFuelForMass(mass){
    let newMassValue = Math.floor(mass/3)-2;
    if(newMassValue<=0){
        return mass;
    }else{
        return mass+(getFuelForMass(newMassValue));
    }
}

function getTotalFuelA(arr){
    let modifiedArr = arr.map(x=> parseInt(Math.floor(x/3)-2));
    return modifiedArr.reduce((a,b) => a+b);
}

function getTotalFuel(arr){
    let modifiedArr = arr.map(x=> getFuelForMass(parseInt(Math.floor(x/3)-2)));
    return modifiedArr.reduce((a,b) => a+b);
}