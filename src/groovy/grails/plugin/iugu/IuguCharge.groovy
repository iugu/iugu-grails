package grails.plugin.iugu


class IuguCharge {

    static iuguService

    // POST https://api.iugu.com/v1/charge
    static create(def attributes) {
        if (!attributes) {
            return false
        }

        iuguService = iuguService ?: new IuguService()

        return iuguService.create("charge", attributes)
    }

}

// Charge.create, CartaoCredito
// [
//     token: "123AEAE123EA0kEIEIJAEI",
//     email: "teste@teste.com",
//     items: [
//         description: "Item Um",
//         quantity: "1",
//         price_cents: "1000"
//     ],
//     payer: [
//         name: "Nome do Cliente",
//         phone_prefix: "11",
//         phone: "12121212",
//         email: "teste@teste.com",
//         address: [
//             street: "Rua Tal",
//             number: "700",
//             city: "São Paulo",
//             state: "SP",
//             country: "Brasil",
//             zip_code: "12122-00"
//         ]
//     ]
// ]

// Charge.create, Boleto
// [
//     method: "bank_slip",
//     email: "teste@teste.com",
//     items: [
//         description: "Item Um",
//         quantity: "1",
//         price_cents: "1000"
//     ],
//     payer: [
//       	cpf_cnpj: "12312312312",
//         name: "Nome do Cliente",
//         phone_prefix: "11",
//         phone: "12121212",
//         email: "teste@teste.com",
//         address: [
//             street: "Rua Tal",
//             number: "700",
//             city: "São Paulo",
//             state: "SP",
//             country: "Brasil",
//             zip_code: "12122-00"
//         ]
//     ]
// ]
