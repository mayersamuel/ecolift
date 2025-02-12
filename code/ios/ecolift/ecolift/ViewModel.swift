import Foundation

class ViewModel: ObservableObject {
    @Published var model: Model

    init(model: Model) {
        self.model = model
    }
    
    var rides: [EclRide] {
        get {
            return model.rides
        }
        set {
            model.rides = newValue
        }
    }
}
