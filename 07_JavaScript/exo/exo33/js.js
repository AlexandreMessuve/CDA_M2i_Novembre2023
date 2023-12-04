let ms = 0;
let sec = 0;
let min = 0;
let hours = 0;
let idInterval;
let count = 0;
const listLaps = [];
const main = document.querySelector('main');
const spanH = document.querySelector('#hour');
const spanM = document.querySelector('#min');
const spanS = document.querySelector('#sec');
const spanMs = document.querySelector('#milisecond');
const button = document.createElement('button');
const reset = document.createElement('button');
const countLap = document.createElement('button');
reset.textContent = 'Reset'
button.textContent = 'Démarrer';
countLap.textContent = 'Compte tour';
main.appendChild(button);
main.appendChild(countLap);
main.appendChild(reset);

const validateTime = (tab, timer) => {
    let bool = false;
    tab.filter((value) => {
        if(value === timer){
            bool = true;
        }
    })
    return bool;
}

button.addEventListener('click', () => {
    if (button.textContent === 'Démarrer') {
        idInterval = setInterval(() => {
            ms++;
            if (ms === 100) {
                ms = 0;
                sec++;
            }
            if (sec === 60) {
                min++;
                sec = 0;
            }
            if (min === 60) {
                hours++;
                min = 0;
            }
            spanH.textContent = hours.toString().length == 1 ? `0${hours}` : hours;
            spanM.textContent = min.toString().length == 1 ? `0${min}` : min;
            spanS.textContent = sec.toString().length == 1 ? `0${sec}` : sec;
            spanMs.textContent = ms.toString().length == 1 ? `0${ms}` : ms;


        }, 10);
        button.textContent = 'Stopper';
    } else {
        clearInterval(idInterval);
        button.textContent = 'Démarrer';
    }


});

reset.addEventListener('click', () => {
    clearInterval(idInterval);
    button.textContent = 'Démarrer';
    ms = 0;
    sec = 0;
    min = 0;
    hours = 0;
    spanH.textContent = '00';
    spanM.textContent = '00';
    spanS.textContent = '00';
    spanMs.textContent = '00';
    const table = document.querySelector('table');
    table.remove();
});

countLap.addEventListener('click', () =>{
    
    const time = `${hours.toString().length == 1 ? `0${hours}` : hours}:${min.toString().length == 1 ? `0${min}` : min}:${sec.toString().length == 1 ? `0${sec}` : sec} ${ms.toString().length == 1 ? `0${ms}` : ms}`;
    if(validateTime(listLaps, time)){
        return;
    };
    let interval;
    if(listLaps.length === 0){
        interval = 'Premier tour';
    }else {
        const index = listLaps.length - 1;
        const lastTime = listLaps[index];
        const regex = new RegExp(/[:\s]/, 'g')
        const result = Number(time.replace(regex, '')) - Number(lastTime.replace(regex, ''));
        interval = `${result}`;
        interval = interval.padStart(8, "0");
        console.log(interval)
    }
    listLaps.push(time);
    count++;
    if(count === 1){
        const table = document.createElement('table');
        const thead = document.createElement('thead');
        const tbody = document.createElement('tbody');
        const thLap = document.createElement('th');
        const thTimer = document.createElement('th');
        const thInterval = document.createElement('th');
        thLap.textContent = 'Tour';
        thTimer.textContent = 'Temps';
        thInterval.textContent = 'Intervalle';
        thead.appendChild(thLap);
        thead.appendChild(thTimer);
        thead.appendChild(thInterval);
        table.appendChild(thead);
        table.appendChild(tbody);
        main.appendChild(table);
    }
    const tbody = document.querySelector('tbody');
    const tr = document.createElement('tr');
    const tdLap = document.createElement('td');
    const tdTimer = document.createElement('td');
    const tdInterval = document.createElement('td');

    tdLap.textContent = count;
    tdTimer.textContent = time;
    tdInterval.textContent = interval;
    tr.appendChild(tdLap);
    tr.appendChild(tdTimer);
    tr.appendChild(tdInterval);
    tbody.appendChild(tr);
});
