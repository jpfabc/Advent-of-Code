function storeDirectBags (bagsInput, bagToSearch,isToStoreOnDirectBags,isToStoreInOtherBags){
    debugger
    let bagsFiltered = bagsInput.filter (x=>x.includes(bagToSearch) && x.indexOf(bagToSearch)>x.indexOf('contain') && !allBags.includes(x));
    for (let i = 0; i < bagsFiltered.length; i++){
        let bagToAdd = getBag(bagsFiltered[i].split(' '));
        if(!allBags.includes(bagToAdd)){
            allBags.push(bagToAdd);
            if(isToStoreInOtherBags){
                otherBags.push(bagToAdd);
            }else if(isToStoreOnDirectBags){
                directBags.push(bagToAdd);
            }
        }else{
            continue;
        }
    }
}

function storeOtherBags(bagsToSearch,bagInput){
    otherBags = [];
    for(let i = 0; i < bagsToSearch.length; i++){
        let bagsFiltered = storeDirectBags(bagInput,bagsToSearch[i],false,true);
    }
    return otherBags;
}

function getBag(input){
    let bag = '';
    let bagIndex = input.indexOf('bags');
    for(let x = 0; x < bagIndex; x++){
        if(x+1 == bagIndex){
            bag += input[x];
        }else{
            bag += input[x] + " "; 
        }
    }
    return bag;
}

function storeDirectShinyBags(){
    storeDirectBags(input,'shiny gold',true,false);
    return;
}

function getAllBags(){
    storeDirectShinyBags();
    storeOtherBags(directBags,input);
    while (otherBags.length != 0){
        storeOtherBags(otherBags,input);
    }
    return allBags.length;
}