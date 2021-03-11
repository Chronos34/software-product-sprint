// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const quotes =
      ['\“I find your lack of faith disturbing.\” — Darth Vader', 
      '\“Never tell me the odds!\” — Han Solo', 
      '\“Do. Or do not. There is no try.\” — Yoda', 
      '\“Fear is the path to the dark side. Fear leads \
      to anger; anger leads to hate; hate leads to suffering. \
      I sense much fear in you.\” — Yoda', '\“If you define yourself \
      by your power to take life, your desire to dominate, to \
      possess, then you have nothing.\” — Obi-Wan Kenobi'];

  // Pick a random greeting.
  const quote = quotes[Math.floor(Math.random() * quotes.length)];

  // Add it to the page.
  const quoteContainer = document.getElementById('quote-container');
  quoteContainer.innerText = quote;
}

async function welcomeMessage() {

    const response = await fetch('/hello');
    const messages = await response.json();
    const randomMessage = messages[Math.floor(Math.random() * messages.length)];

    const messageContainer = document.getElementById('star');
    messageContainer.innerText = randomMessage;
}

async function analyzeMessage() {

    /**
     * The parameters object is responsible for
     * sending the user's messages to the form handler
     * servlet. This makes it easier to generate warnings
     * for abusive users based on how low the sentiment
     * score is.
     */
    const message = document.getElementById("message").value;
    const parameters = new URLSearchParams();
    parameters.append("text-input", message);

    const response = await fetch('/form-handler', {method: 'POST', body: parameters});
    console.log(response.text().trim());
}