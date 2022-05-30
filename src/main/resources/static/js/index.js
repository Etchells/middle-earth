const urlGetAllCharacters = 'http://localhost:8080/rest/readfromdb';
const urlDeleteCharacter = 'http://localhost:8080/rest/delete';
const urlCharacterUpdate = 'http://localhost:8080/rest/update';
const urlCreateCharacter = 'http://localhost:8080/rest/create';

let firstNameText = document.getElementById('first-name');
let lastNameText = document.getElementById('last-name');
let locationText = document.getElementById('location');
let ageText = document.getElementById('age');
let raceText = document.getElementById('race');

const btnSubmit = document.querySelector('.btn');
const addCharacterForm = document.querySelector('.add-character-form');

// Get All -------------------------------------------------------------------------------------
fetch(urlGetAllCharacters)
    .then(res => res.json())
    // .then(data => console.log(data)); // for testing
    .then(data => renderCharacters(data))

const characterList = document.querySelector('.character-list');

let output = '';

const renderCharacters = (characters) => {
    characters.forEach(character => {
        // console.log(character); // for testing
        output += `
        <div class="card mt-4 col-md-6 bg-ligt">
        <div class="card-body" data-id=${character.id}>
            <h5 class="card-title1">${character.firstName}</h5>
            <h5 class="card-title2">${character.lastName}</h5>
            <h6 class="card-subtitle1 mb-2 text-muted">${character.location}</h6>
            <h6 class="card-subtitle2 mb-2 text-muted">${character.age}</h6>
            <h6 class="card-subtitle3 mb-2 text-muted">${character.race}</h6>
            <p class="card-text"></p>
            <a href="#" class="card-link" id="update-character">Update</a>
            <a href="#" class="card-link" id="delete-character">Delete</a>
        </div>
        </div>
        `;
    });
    characterList.innerHTML = output;
}
// End Get All -------------------------------------------------------------------------------------

// Delete and Update -------------------------------------------------------------------------------------

characterList.addEventListener('click', (e) => {

    // console.log(e.target.id); // for testing
    e.preventDefault();
    let updateButtonIsPressed = e.target.id == 'update-character';
    let deleteButtonIsPressed = e.target.id == 'delete-character';

    // console.log(e.target.parentElement.dataset.id); // for testing
    let id = e.target.parentElement.dataset.id;

    // Delete - remove existing character
    // Method: DELETE
    if (deleteButtonIsPressed) {
        // console.log('Delete button was pressed'); // for testing
        fetch(`${urlDeleteCharacter}/${id}`, {
            method: 'DELETE',
        })
            .then(res => res.json())
            .then(() => location.reload())
        // Note to delete click the button twice !!!!!!!
    }



    // // Update existing character
    // // Method: PATCH
    if (updateButtonIsPressed) {
        // console.log('Update button was pressed'); // for testing
        const parent = e.target.parentElement;
        let titleContent1 = parent.querySelector('.card-title1').textContent;
        let titleContent2 = parent.querySelector('.card-title2').textContent;
        let subContents1 = parent.querySelector('.card-subtitle1').textContent;
        let subContents2 = parent.querySelector('.card-subtitle2').textContent;
        let subContents3 = parent.querySelector('.card-subtitle3').textContent;
        // console.log(subContents1) // for testing

        firstNameText.value = titleContent1;
        lastNameText.value = titleContent2;
        locationText.value = subContents1;
        ageText.value = subContents2;
        raceText.value = subContents3;
        // console.log(locationText) // for testing
    }



    btnSubmit.addEventListener('click', (e) => {
        e.preventDefault()
        // console.log('character updated') // for testing

        // let headers = new Headers();

        // headers.append('Content-Type', 'application/json');
        // headers.append('Accept', 'application/json');

        // headers.append('Access-Control-Allow-Origin', 'http://127.0.0.1:5500/');
        // headers.append('Access-Control-Allow-Credentials', 'true');

        // headers.append('GET', 'POST', 'OPTIONS', 'PUT');

        fetch(`${urlCharacterUpdate}/${id}`, {
            method: 'PUT',
            // mode: 'cors',
            headers: {
                "Content-Type": "application/json; charset=UTF-8"
            },
            body: JSON.stringify({
                firstName: firstNameText.value,
                lastName: lastNameText.value,
                location: locationText.value,
                age: ageText.value,
                race: raceText.value
            }),
        })
            .then(res => res.json())
            .then(() => location.reload())
    })
});
// End Delete and Update -------------------------------------------------------------------------------------

// Create -------------------------------------------------------------------------------------
// Add new character
// Method: Post


addCharacterForm.addEventListener('submit', (e) => {
    e.preventDefault();

    let firstName = document.getElementById('first-name').value
    let lastName = document.getElementById('last-name').value
    let location = document.getElementById('location').value
    let age = document.getElementById('age').value
    let race = document.getElementById('race').value

    fetch(`${urlCreateCharacter}`, {
        method: 'POST',
        body: JSON.stringify({
            firstName: firstName,
            lastName: lastName,
            location: location,
            age: age,
            race: race
        }),
        headers: {
            "Content-Type": "application/json; charset=UTF-8"
        }
    })
        .then(res => res.json())
        .then(data => {
            const dataArr = [];
            dataArr.push(data);
            renderCharacters(dataArr);
            // console.log(data); // for testing
        })
        .then(() => location.reload)
})
// End Create -------------------------------------------------------------------------------------
