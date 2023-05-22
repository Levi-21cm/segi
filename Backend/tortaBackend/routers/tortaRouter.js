const express = require('express')
const tortaController = require('../controllers/tortaController')

const router = express.Router()

router
    .route('/')
    .post(tortaController.creatTorta)
    .get(tortaController.getAllTorta);

router
    .route('/:id')
    .get(tortaController.getTortabyId)
    .patch(tortaController.updateTorta)
    .delete(tortaController.deleteTorta);

module.exports = router;