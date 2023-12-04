export default class Person {
    #id;
    #firstname;
    #lastname;
    #birthday;
    #gender;
    static count = 0;

    constructor(){
        Person.count++
        this.#id = Person.count;
    }

    getId(){
        return this.#id
    }
    getFullname(){
        return this.#lastname.toUpperCase() + ' ' + this.#firstname.substring(0,1).toUpperCase() + this.#firstname.substring(1);
    }
    setFirstname(firstname){
        if (firstname === 'jeremy'){
            Person.count--;
            return false;
        }
        this.#firstname = firstname;
        return true;
    }
    setLastname(lastname){
        this.#lastname = lastname;
    }

    getBirth(){
        return this.#birthday;
    }
    setBirth(birthday){
        this.#birthday = birthday;
    }

    getGender(){
        return this.#gender;
    }
    setGender(gender){
        this.#gender = gender;
    }
}