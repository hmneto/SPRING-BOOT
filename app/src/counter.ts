import { encode } from "base-64";

export function setupCounter(element: HTMLButtonElement) {
  let counter = 0
  const setCounter = (count: number) => {
    // fetch("http://ip172-18-0-5-cdjv4463tccg00d5v9s0-80.direct.labs.play-with-docker.com/user").then(x=>x.text()).then(x=>console.log(x))
    const username = 'admin'
    const password = '123'
    fetch('http://ip172-18-0-14-cdk2qmf91rrg00fv7c80-80.direct.labs.play-with-docker.com/user',
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
