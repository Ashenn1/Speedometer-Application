# BlockGrade

BlockGrade is a blockchain-based system for creating, verifing and viewing courses grades and certificates. Built upon Ethereum blockchain.
The project is still a proof of concept.


##Setting up environment:

###Before you start, make sure to have these available:

* [Node.js and npm](https://nodejs.org/en/), npm is a package manager that you need to run the dApp.
* A Unix shell, if you're a Windows user you'll need to install [Git bash](https://git-scm.com/).


###Once you have requirements installed:

1. Install Truffle framwork with the following
   command using Git bash or your favourite terminal 
   `npm install -g truffle`,
   Truffle is a Smart Contracts development environment that you need to run this project.
   Run `truffle version` to check that Truffle is installed correctly, it should output no errors.

2. Then you need to install [Ganache](https://truffleframework.com/ganache), a personal blockchain for
   Ethereum that you will use to deploy contracts and run tests.

3. Last but not least, install [MetaMask](https://metamask.io/), a browser extension for both Chrome
   and Firefox to interact with our dApp.


###Configuring Ganache and MetaMask:

You need to configure Ganache and MetaMask before you can start interacting with the dApp.

1. Open the fox icon in your browser bar and start Ganache.

2. At the intial MetaMask screen. Click **Import Existing DEN.**

3. In the box marked **Wallet Seed**, enter the mnemonic that is displayed in Ganache.

4. Now you need to connect MetaMask to the blockchain created by Ganache. Click the menu that shows "Main Network" and select **Custom RPC**.

5. In the box titled "New RPC URL" enter the RPC server displayed in Ganache and click **Save**. 


###Running the dApp:

1. Clone the repository.

2. Change directory to the project.
   `cd blockgrade`

3. Make sure Ganache and MetaMask are configured.

3. Run `truffle compile`, then `truffle migrate` in the terminal.

4. Run `npm run dev` in the terminal to start the local web server.
