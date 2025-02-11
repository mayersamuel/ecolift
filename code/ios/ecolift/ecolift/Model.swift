import Foundation

struct Trip: Codable, Identifiable {
    var id: String
    var from: String
    var to: String
    var time: String
    var seats: Int
    var notes: String
}

struct Model {
    var trips: [Trip] = []
}
