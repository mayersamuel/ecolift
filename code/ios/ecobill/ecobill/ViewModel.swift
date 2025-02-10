import Foundation

class ViewModel: ObservableObject {
    @Published var model: Model
    init(model: Model) {
        self.model = model
    }
}
