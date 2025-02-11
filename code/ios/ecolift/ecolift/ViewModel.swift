import Foundation

class ViewModel: ObservableObject {
    @Published var model: Model

    init(model: Model) {
        self.model = model
    }
    
    var trips: [Trip] {
        get {
            return model.trips
        }
        set {
            model.trips = newValue
        }
    }
}
