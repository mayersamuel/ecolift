import Foundation

let base_URL = "http://localhost:8080"

func getAllTrips() -> [EclRide] {
    var data: [EclRide] = []
    
    let url = base_URL + "/ride"
    guard let url = URL(string: url) else {
        print("Invalid URL")
        return data
    }

    do {
        let encodetData = try Data(contentsOf: url)
        let decoder = JSONDecoder()
        data = try decoder.decode([EclRide].self, from: encodetData)
        print("data: \(data)")
    } catch {
        print("Error: \(error)")
    }
    return data
}
