import Foundation

let base_URL = "http://localhost:8080"

func getAllTrips() -> [Trip] {
    var data: [Trip] = []
    
    let url = base_URL + "/trip" //validate Route
    guard let url = URL(string: url) else {
        print("Invalid URL")
        return data
    }

    do {
        let encodetData = try Data(contentsOf: url)
        let decoder = JSONDecoder()
        data = try decoder.decode([Trip].self, from: encodetData)
        print("data: \(data)")
    } catch {
        print("Error: \(error)")
    }
    return data
}
