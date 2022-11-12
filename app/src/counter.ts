import { encode } from "base-64";

export function setupCounter(element: HTMLButtonElement) {
  let counter = 0
  const setCounter = (count: number) => {
    const username = 'admin'
    const password = '123'
    fetch('http://localhost/admin',
     {method:'GET', 
     headers: new Headers(
      {
      'Authorization': 'Basic ' + encode(username + ":" + password),
      'Content-Type': 'application/json'
    }
    )}
    
    )

.then(response => response.text())
.then(json => console.log(json));
    
    
    counter = count
    element.innerHTML = `count is ${counter}`
  }
  element.addEventListener('click', () => setCounter(counter + 1))
  setCounter(0)
}





// git clone https://github.com/hmneto/SPRING-BOOT-AUTHORIZE-AUTHENTICATION.git && cd SPRING-BOOT-AUTHORIZE-AUTHENTICATION && git checkout cors && docker-compose up --build
