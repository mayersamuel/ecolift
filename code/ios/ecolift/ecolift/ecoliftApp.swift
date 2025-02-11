import SwiftUI

@main
struct ecoliftApp: App {
    let model = Model()
    var body: some Scene {
        let viewModel = ViewModel(model: model)
        WindowGroup {
            ContentView(viewModel: viewModel)
        }
    }
}
