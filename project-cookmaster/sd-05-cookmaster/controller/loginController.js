const jwt =
const { Router } = require('express');
const { userExists } = require('../service').login;

const route = Router();

route.post('/', async (req, res) => {
  const { email, password } = req.body;
  const userId = await userExists(email, password);
  if (userId.message) {
    return res.status(401).json(userId);
  }

  const token = jwt.sign({ id }, process.env.SECRET, {
    expiresIn: 300 // expires in 5min
  });

  return res.status(200).json(userId);
});

module.exports = route;
