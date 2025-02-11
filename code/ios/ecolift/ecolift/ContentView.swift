import SwiftUI

struct ContentView: View {
    let queue = DispatchQueue(label: "ac.at.leonding.download")
    @State var selectedTab = 0
    @ObservedObject var viewModel: ViewModel
    
    var body: some View {
        TabView(selection: $selectedTab) {
            BookTripView(viewModel: viewModel)
                .tabItem {
                    Image(systemName: "figure.wave")
                    Text("Book Trip")
                }
                .tag(0)
            CreteTripView()
                .tabItem {
                    Image(systemName: "plus.circle")
                    Text("Create Trip")
                }
                .tag(1)
            SettingsView()
                .tabItem {
                    Image(systemName: "gear")
                    Text("Settings")
                }
                .tag(2)
        }
        .padding(.top, 10)
        .task {
            queue.async(execute: {
                let trips = getAllTrips()
                DispatchQueue.main.async(execute: {
                    viewModel.trips = trips
                })
            })
        }
    }
}

#Preview {
    var model = Model()
    var viwModel = ViewModel(model: model)
    ContentView(selectedTab: 0, viewModel: viwModel)
}
