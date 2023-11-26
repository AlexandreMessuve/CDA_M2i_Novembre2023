let isPalindrome = (string) => {
    let lengthString = string.length;
    string = string.trim().toLowerCase();
    for (let char = 0; char < lengthString/2; char++){
        if(string[char] !== string[lengthString - 1 - char]){
            return false;
        }
    }
    return true;
}

let str = prompt('Veuillez saisir une phrase ou un mot.');

if(isPalindrome(str)){
    console.log(`${str} est palindrome`)
}else{
    console.log(`${str} n'est pas palindrome`)
}
