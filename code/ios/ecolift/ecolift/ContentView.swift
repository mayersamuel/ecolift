import SwiftUI

struct ContentView: View {
    let queue = DispatchQueue(label: "ac.at.leonding.download")
    @State var selectedTab = 0
    @ObservedObject var viewModel: ViewModel
    
    var body: some View {
        TabView(selection: $selectedTab) {
            RideTripView(viewModel: viewModel)
                .tabItem {
                    Image(systemName: "figure.wave")
                    Text("Book Ride")
                }
                .tag(0)
            HostRideView()
                .tabItem {
                    Image(systemName: "plus.circle")
                Text("Create Ride")
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
                let rides = getAllTrips()
                DispatchQueue.main.async(execute: {
                    viewModel.rides = rides
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
